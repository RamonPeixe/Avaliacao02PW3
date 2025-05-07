package br.ifsp.edu.br.Avaliacao02.controller;

import br.ifsp.edu.br.Avaliacao02.dto.RepairDetail;
import br.ifsp.edu.br.Avaliacao02.dto.RepairRequest;
import br.ifsp.edu.br.Avaliacao02.dto.RepairSummary;
import br.ifsp.edu.br.Avaliacao02.dto.RepairUpdateRequest;
import br.ifsp.edu.br.Avaliacao02.model.MechanicInfo;
import br.ifsp.edu.br.Avaliacao02.model.RepairJob;
import br.ifsp.edu.br.Avaliacao02.model.VehicleInfo;
import br.ifsp.edu.br.Avaliacao02.repository.RepairRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairController {

    @Autowired
    private RepairRepository repo;

    @PostMapping
    @Transactional
    public ResponseEntity<RepairDetail> create(
            @RequestBody @Valid RepairRequest req,
            UriComponentsBuilder uriBuilder
    ) {
        var mech = new MechanicInfo(req.mechanic().mechName(), req.mechanic().mechYears());
        var veh  = new VehicleInfo(req.vehicle().vehMake(), req.vehicle().vehModel(), req.vehicle().vehYear(), req.vehicle().vehColor());
        var job  = new RepairJob(req.entryDate(), req.exitDate(), mech, veh);
        repo.save(job);

        URI uri = uriBuilder.path("/repairs/{id}")
                .buildAndExpand(job.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(new RepairDetail(job));
    }

    @GetMapping
    public ResponseEntity<Page<RepairDetail>> listAll(
            @PageableDefault(sort="entryDate", size=10) Pageable pg
    ) {
        Page<RepairJob> page = repo.findAllByActiveTrue(pg);
        var dtoPage = page.map(RepairDetail::new);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<RepairSummary>> listSummary() {
        List<RepairJob> list = repo.findAllByActiveTrue();
        var dtos = list.stream().map(RepairSummary::new).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairDetail> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .filter(RepairJob::isActive)
                .map(RepairDetail::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RepairDetail> update(
            @PathVariable Long id,
            @RequestBody @Valid RepairUpdateRequest req
    ) {
        return repo.findById(id)
                .map(job -> {
                    var mech = new MechanicInfo(req.mechName(), req.mechYears());
                    job.updateExit(req.exitDate(), mech);
                    return ResponseEntity.ok(new RepairDetail(job));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id)
                .map(job -> {
                    job.deactivate();
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
package com.java.fazjaune.learning.web;

import com.java.fazjaune.learning.model.Photo;
import com.java.fazjaune.learning.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class LearningController {

    private final PhotosService photosService;

    public LearningController(PhotosService photosService) {
        this.photosService = photosService;
    }
//    private final List<Photo> db = List.of(new Photo("1", "hello.jpg"));

//    @GetMapping("/")
//    public String hello() {
//        return "index.html";
//    }

    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photosService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photosService.remove(id);
//        Photo photo = photosService.remove(id);
//        if (photo == null) return ResponseEntity.notFound().build();

//        return ResponseEntity.ok().body("Deleted");
    }

//    @PostMapping("/photos")
//    public ResponseEntity<Map<String, Object>> create(@RequestBody Photo body) {
//        if (body == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        Integer newId = db.size() + 1;
//        db.put(newId.toString(), new Photo(newId.toString(), body.getFileName()));
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newId.toString())
//                .toUri();
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "Record Saved successflly !");
//        response.put("redirectUri", uri.toString());
//        response.put("data", body);
//
//
//        return ResponseEntity.created(URI.create(uri.toString())).body(response);
//    }

    @PostMapping("/photos")
//    public Photo create(@RequestBody @Valid Photo photo) {
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        Photo photo = photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

        return photo;
    }
}
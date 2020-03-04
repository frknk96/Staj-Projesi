package com.ElasticStaj.controller;


import com.ElasticStaj.dao.QueryDAO;
import com.ElasticStaj.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class RestRequestController {
    @Autowired
    private final QueryDAO dao;

    @Autowired
    public RestRequestController(QueryDAO dao) {
        this.dao = dao;
    }

    /**
     *
     * @param document
     * @return
     */
    @PostMapping(value = "/api/create", consumes = "application/json; charset=utf-8")
    public String create(@RequestBody Document document) {
        return dao.createIndex(document);
    }

    @PostMapping(value = "/api/update", consumes = "application/json; charset=utf-8")
    public String update(@RequestBody Document document){
        return dao.updateDocument(document);
    }

    /**
     *
     * @param id
     */
    @GetMapping(value = "/api/delete")
    public void delete(String id){
        dao.deleteDocument(id);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/api/all", produces = "application/json; charset=utf-8")
    public List<Document> getAllDocuments() {
        return dao.matchAllQuery();
    }

    /**
     *
     * @param query
     * @return
     */
    @GetMapping("/api/search")
    public List<Document> search(@RequestParam("query") String query) {
        return dao.wildcardQuery(query);
    }
}

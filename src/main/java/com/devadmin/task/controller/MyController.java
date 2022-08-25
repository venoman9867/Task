package com.devadmin.task.controller;

import com.devadmin.task.entity.City;
import com.devadmin.task.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;


@RestController
public class MyController {
    public @Autowired CityRepository repository;

    @PostMapping("/create")
    private Object createData(HttpServletRequest request) {
        String name = request.getParameter("n");
        int countryCode = Integer.valueOf(request.getParameter("c"));
        String district = request.getParameter("d");
        long population = Long.valueOf(request.getParameter("p"));

        if (Objects.isNull(name) || Objects.isNull(district))
            return ResponseEntity.badRequest();

        City city = new City();
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);
        return repository.save(city);
    }

    @DeleteMapping("/delete")
    private Object deleteData(HttpServletRequest request) {
        Optional.of("id").map(request::getParameter).map(Long::valueOf).ifPresent(repository::deleteById);
        return "Success!";
    }

    @PutMapping("/update")
    private Object updateData(HttpServletRequest request) {
        var city = repository.findById(Long.valueOf(request.getParameter("id"))).orElseThrow();
        Optional.of("n").map(request::getParameter).ifPresent(city::setName);
        Optional.of("c").map(request::getParameter).map(Integer::valueOf).ifPresent(city::setCountryCode);
        Optional.of("d").map(request::getParameter).ifPresent(city::setDistrict);
        Optional.of("p").map(request::getParameter).map(Long::valueOf).ifPresent(city::setPopulation);
        return repository.save(city);
    }


    @GetMapping("/list")
    private Object listData() {
        return repository.findAll();
    }


}

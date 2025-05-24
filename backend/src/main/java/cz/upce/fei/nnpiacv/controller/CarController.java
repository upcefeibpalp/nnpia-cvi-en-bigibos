package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.Car;
import cz.upce.fei.nnpiacv.dto.CarRequestDTO;
import cz.upce.fei.nnpiacv.dto.CarRespondDTO;
import cz.upce.fei.nnpiacv.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PutMapping("/cars/{id}")
    public CarRespondDTO updateCar(@PathVariable Long id, @Valid @RequestBody CarRequestDTO car) {
        return carService.updateCar(id, car);
    }

    @PostMapping("/cars")
    public CarRespondDTO addCar(@Valid @RequestBody CarRequestDTO car) {
        return carService.addCar(car);
    }

    @DeleteMapping("/cars/{id}")
    public CarRespondDTO deleteCar(@PathVariable Long id) {
        return carService.deleteCar(id);
    }

    @GetMapping("/cars/{id}")
    public CarRespondDTO findCar(@PathVariable Long id) {
        return carService.findCar(id);
    }

    @GetMapping("/cars")
    public Collection<CarRespondDTO> getCars() {
        return carService.findCars();
    }

}

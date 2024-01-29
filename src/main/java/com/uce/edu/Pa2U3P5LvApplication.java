package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.hotel.repository.modelo.Habitacion;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;
import com.uce.edu.demo.hotel.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5LvApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("INNER JOIN");
		List<Hotel> hotel = this.hotelService.buscarHotelesPorNombre("HotelA");
		for(Hotel h : hotel) {
			System.out.println(h);
		}
		
		System.out.println("LEFT JOIN");
		List<Hotel> hotel2 = this.hotelService.buscarHotelesPorEstado("Construccion");
		for(Hotel h : hotel2) {
			System.out.println(h);
		}
		
		System.out.println("RIGHT JOIN");
		List<Hotel> hotel3 = this.hotelService.buscarHotelesConHabitacionesConstruidas("Construccion");
		for(Hotel h : hotel3) {
			System.out.println(h);
		}
		
		System.out.println("FULL JOIN");
		List<Hotel> hote4 = this.hotelService.buscarHoteles();
		for(Hotel h : hote4) {
			System.out.println(h);
		}
		
		
		
		
	}

}

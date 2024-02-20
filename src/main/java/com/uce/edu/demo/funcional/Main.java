package com.uce.edu.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Supplier
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>SUPPLIER");
		// Clases
		System.out.println("clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// lambdas
		System.out.println("lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "12345";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		// lambdas2
		System.out.println("lambdas");
		IPersonaSupplier<String> supplierLambda2 = () -> "54321" + "pais";
		System.out.println(supplierLambda2.getId());
		// lambdas3
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		MetodosReferenciados met =new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4= met::obtenerId;
		System.out.println(supplierLambda4.getId());
		
		
		
		// 2. CONSUMER
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>CONSUMER");
		// clases
		System.out.println("clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		// lambda
		System.out.println("lambdas");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Estudiante");
		//metodos referenciados
		System.out.println("Metodo referenciado");
		IPersonaConsumer<String> consumerLambda2 =  met :: procesar;
		consumerLambda2.accept("Luis referenciado");
		
		
		
		// 3.Predicate
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>PREDICATE");
		// CLASES
		// NO BENEFICIO
		// LAMBDAS
		System.out.println("lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(5));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Luis".contains(letra);
		System.out.println(predicateLambda2.evaluar("L"));
		//metodos referenciados
		System.out.println("Metodo referenciado");
		IPersonaPredicate<String> predicate2 = met ::evaluar;
		System.out.println(predicate2.evaluar("L"));
		
		IPersonaPredicate<Integer> predicate3 = met ::procesar;
		System.out.println(predicate3.evaluar(10));
		
		
		
		// 4. Function
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>FUNCTION");
		// lambda
		System.out.println("lambdas");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero= numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));
		
		IPersonaFunction<Empleado, Ciudadano> functionLambda2 = ciudadano -> {
			Empleado emp = new Empleado();
			emp.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());;
			if(ciudadano.getProvincia().compareTo("pichincha")==0) {
				emp.setPais("Ecuador");
			}
			return emp;
		};
		
		Ciudadano ciu= new Ciudadano();
		ciu.setNombre("Luis");
		ciu.setApellido("Valladares");
		ciu.setProvincia("pichincha");
		
		Empleado emp = functionLambda2.aplicar(ciu);
		System.out.println(emp);
		//metodos referenciados
		Empleado emp2 = new Empleado();
		emp2.setNombreCompleto("Jose casa");
		emp2.setPais("Ecuador");
		System.out.println("Metodo referenciado");
		IPersonaFunction<Ciudadano, Empleado> function2 = met :: cambiar;
		Ciudadano ciu2 =function2.aplicar(emp2);
		System.out.println(ciu2);
		
		
		//5.Unary Operator
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>Unary Operatot");
		//lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda.aplicar(14));
		//Lambda2
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda2.aplicar(10));
		//metodos referenciados
		System.out.println("Metodo referenciado");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met ::procesar;
		Empleado emp3=unary3.aplicar(emp2);
		System.out.println(emp3);
		
		
		
		System.out.println();
		System.out.println("************ IMPLEMENTACION DE INTERFACES FUNCIONALES MEDIANTE LIBRERIAS JAVA ************");
		//1.SUPPLIER
		System.out.println("SUPPLIER JAVA");
		Stream<String> lista = Stream.generate(() -> "54321" + "pais").limit(20);
		lista.forEach(cadena->System.out.println(cadena));
		
		//2. CONSUMER
		System.out.println("CONSUMER JAVA");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6,11,58);
		listaNumeros.forEach(numero -> {
			System.out.println("Se inserta");
			System.out.println(numero);
		});
		
//		for(Integer numero : lista2 ) {
//			System.out.println("Se inserta");
//			System.out.println(numero);
//		}
		
		//3.PREDICATE
		System.out.println("PREDICATE JAVA");
		Stream<Integer> listaFiltrada=listaNumeros.stream().filter( numero -> numero >=10);
		listaFiltrada.forEach(numero ->System.out.println(numero));
		
		//4. FUNCTION
		System.out.println("FUNCTION JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero ->{
			numero = numero*100/50;
			return "num: "+numero.toString();
		} );
		listaCambiada.forEach(cadena-> System.out.println(cadena));
		//ejemplo2
		Ciudadano ciud1= new Ciudadano();
		ciud1.setNombre("Luis");
		ciud1.setApellido("Valladares");
		ciud1.setProvincia("pichincha");
		Ciudadano ciud02= new Ciudadano();
		ciud02.setNombre("Ernesto");
		ciud02.setApellido("Bastidas");
		ciud02.setProvincia("pichincha");
		Ciudadano ciud03= new Ciudadano();
		ciud03.setNombre("Viviana");
		ciud03.setApellido("Jacome");
		ciud03.setProvincia("pichincha");
		List<Ciudadano> listaCiudadanos = Arrays.asList(ciud1,ciud02,ciud03);
		Stream<Empleado> listaEmpleado = listaCiudadanos.stream().map(ciudadano -> {
			Empleado empl01 = new Empleado();
			empl01.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());;
			if(ciudadano.getProvincia().compareTo("pichincha")==0) {
				empl01.setPais("Ecuador");
			}
			return empl01;
		});
		listaEmpleado.forEach(empleado -> System.out.println(empleado));
		
		//5. Unary Operator
		System.out.println("UNARY OPERATOR JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero ->{
			numero = numero*100/50;
			return numero;
		} );
		listaNumeros2.forEach(numero-> System.out.println(numero));
		
		
		
		
	}

}

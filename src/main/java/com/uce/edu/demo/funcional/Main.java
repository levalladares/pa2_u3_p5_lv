package com.uce.edu.demo.funcional;

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
		IPersonaSupplier<String> supplierLambda2 = () -> "54321"+"pais";
		System.out.println(supplierLambda2.getId());
		// lambdas3
		IPersonaSupplier<Integer> supplierLambda3= () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1= valor1* Integer.valueOf(50)/Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		
		//Metodos referenciados
		
		
		//2. CONSUMER
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>CONSUMER");
		//clases
		System.out.println("clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		//lambda
		System.out.println("lambdas");
		IPersonaConsumer<String> consumerLambda =cadena ->{
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Estudiante");
		
		
		//3.Predicate
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>PREDICATE");
		//CLASES
		//NO BENEFICIO
		//LAMBDAS
		System.out.println("lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(5));
		
		IPersonaPredicate<String> predicateLambda2 = letra -> "Luis".contains(letra);
		System.out.println(predicateLambda2.evaluar("L"));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

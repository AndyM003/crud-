import java.util.Scanner;

public class Principal{

    //Entradas
    static Scanner entradaTexto = new Scanner(System.in);
    static Scanner entradaNumerica = new Scanner(System.in);

    //Base Clientes
    private static Cliente [] matrizCliente = new Cliente[1];
    private static Cliente [] copiaCliente = new Cliente[1];

    //Base Empleados
    private static Empleado [] matrizEmpleado = new Empleado[1];
    private static Empleado [] copiaEmpleado = new Empleado[1];

    //Base Alumno
    private static Alumno [] matrizAlumno = new Alumno[1];
    private static Alumno [] copiaAlumno = new Alumno[1];



    //Menu principal | METODO
    private static int menu(){
        int respuesta = 0;
        String menu = "Selecciona a una de nuestras opciones" +
                "\n1. Cliente" +
                "\n2. Empleado" +
                "\n3. Alumno" +
                "\n4. Salir";

        while (respuesta!=4){

            System.out.println(menu);
            System.out.print("Respuesta: ");
            respuesta = entradaNumerica.nextInt();

            if(respuesta<1||respuesta>4){
                System.out.println("\nTe has equivocado, esa respuesta no entra en nuestro menu");
            }else{
                break;
            }
        }

        return respuesta;
    }


    //Menu Opciiones | METODO
    private static int eleccionOpcion(){
        int respuesta = 0;

        String menu = "Selecciona a una de nuestras opciones" +
                "\n1. Visualizar" +
                "\n2. Agregar" +
                "\n3. Eliminar" +
                "\n4. Modicar" +
                "\n5. Salir";

        while (respuesta!=4){

            System.out.println(menu);
            System.out.print("Respuesta: ");
            respuesta = entradaNumerica.nextInt();

            if(respuesta<1||respuesta>5){
                System.out.println("\nTe has equivocado, esa respuesta no entra en nuestro menu");
            }else{
                break;
            }
        }

        return respuesta;
    }


    //CLIENTE || METODOS
    private static void opcionesCliente(int eleccion){

        //Variables de CLIENTE
        int factura = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String producto = "";
        double precio = 0.00;
        int pocision = 0;

        //Modificar
        int modificar = 0;

        //Viendo Seleccion de Menu
        switch (eleccion){
            //Visualizar
            case 1:
                System.out.print("\nIngresa el numero de factura que deseas visualizar: ");
                factura = entradaTexto.nextInt();
                System.out.println("Procesando...");

                pocision = busquedaCliente(factura);

                if(pocision!=0){
                    System.out.println("Proceso finalizado" +
                            "\nResultado:");
                    matrizCliente[pocision].mostrarCliente();
                }else{
                    System.out.println("La persona que buscas no existe");
                }
                break;

            //Agregar
            case 2:
                System.out.print("\nIngresa el numero de factura: ");
                factura = entradaTexto.nextInt();
                System.out.print("\nIngresa el nombre de la factura que deseas Modificar: ");
                nombre = entradaTexto.nextLine();
       
                System.out.print("\nIngresa el apellido de la factura que deseas Modificar: ");
                apellido = entradaTexto.nextLine();
                System.out.print("\nIngresa el edad de la factura que deseas Modificar: ");
                edad = entradaNumerica.nextInt();
                System.out.print("\nIngresa el producto de la factura que deseas Modificar: ");
                producto = entradaTexto.nextLine();
                System.out.print("\nIngresa el precio de la factura que deseas Modificar: ");
                precio = entradaNumerica.nextDouble();

                System.out.println("\nProcesando...");

                pocision = busquedaCliente(factura);

                if(pocision==0){
                    for(int i = 0; i < matrizCliente.length; i++){
                        copiaCliente[i] = matrizCliente[i];
                    }

                    matrizCliente = new Cliente[copiaCliente.length+1];

                    for (int i = 0; i < matrizCliente.length; i++){
                        if(i==(matrizCliente.length-1)){
                            matrizCliente[i] = new Cliente(nombre, apellido, edad, factura, producto, precio);
                        }else{
                            matrizCliente[i] = copiaCliente[i];
                        }
                    }

                    copiaCliente = new Cliente[matrizCliente.length];

                    System.out.println("Proceso terminado, se ha agregado con exito");

                }else{
                    System.out.println("\nEstas intentando agregar una factura existente");
                }

                break;

            //Eliminar
            case 3:
                System.out.print("\nIngresa el numero de factura que deseas eliminar: ");
                factura = entradaNumerica.nextInt();
                pocision = busquedaCliente(factura);

                if(pocision==0){
                    System.out.println("\nLa factura que quieres eliminar no existe");
                }else{

                    copiaCliente = new Cliente[matrizCliente.length-1];

                    for(int i = 0; i < copiaCliente.length; i++){
                        if(i==pocision){
                            continue;
                        }else{
                            copiaCliente[i] = matrizCliente[i];
                        }
                    }

                    matrizCliente = new Cliente[copiaCliente.length];

                    for (int i = 0; i < copiaCliente.length; i++){
                        matrizCliente[i] = copiaCliente[i];
                    }

                    System.out.println("\nFelicidades factura eliminada con exito");
                }
                break;

            //Modificar
            case 4:

                System.out.println("\nQue factura deseas modificar?");
                factura = entradaNumerica.nextInt();

                pocision = busquedaCliente(factura);

                if (pocision==0){
                    System.out.println("La factura que buscas no existe");
                }else{
                    matrizCliente[pocision].mostrarCliente();
                    System.out.println("\nDeseas modificar este usuario?\n" +
                            "1. Si\n" +
                            "CUALQUIER OTRA RESPUESTA SERA TOMADA COMO NO");
                    modificar = entradaNumerica.nextInt();
                    if (modificar==1){
                        for (int i = 0; i<matrizCliente.length; i++){
                            copiaCliente[i] = matrizCliente[i];
                        }

                        for(int i = 0; i < matrizCliente.length; i++){
                            if(i==pocision){
                                System.out.print("\nIngresa el nombre de la persona que deseas agregar: ");
                                nombre = entradaTexto.nextLine();
                                System.out.print("\nIngresa el apellido de la persona que deseas agregar: ");
                                apellido = entradaTexto.nextLine();
                                System.out.print("\nIngresa el edad de la persona que deseas agregar: ");
                                edad = entradaNumerica.nextInt();
                                System.out.print("\nIngresa el producto de la persona que deseas agregar: ");
                                producto = entradaTexto.nextLine();
                                System.out.print("\nIngresa el precio de la persona que deseas agregar: ");
                                precio = entradaNumerica.nextDouble();
                                matrizCliente[i] = new Cliente(nombre, apellido, edad, factura, producto, precio);
                            }else{
                                matrizCliente[i] = copiaCliente[i];
                            }
                        }
                    }
                    System.out.println("\nFelicidades, factura actualizada con exito");
                }
                break;

            //Salir
            case 5:
                System.out.println("\nDe vuelta a nuestro menu principal: \n");
                break;
        }
    }

    //busqueda factura
    private static int busquedaCliente(int factura){
        int pocision = 0;

        for(int i = 0; i < matrizCliente.length; i++){
            if(matrizCliente[i].getFactura()==factura){
                pocision = i;
                break;
            }
        }
        return pocision;
    }

    //EMPLEADO || METODOS
    private static void opcionesEmpleado(int eleccion){
        //Variables de CLIENTE
        int carnet = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        double precio = 0.00;
        int pocision = 0;

        //Modificar
        int modificar = 0;

        //Viendo Seleccion de Menu
        switch (eleccion){
            //Visualizar
            case 1:
                System.out.print("\nIngresa el numero de empleado que deseas visualizar: ");
                carnet = entradaTexto.nextInt();
                System.out.println("Procesando...");

                pocision = busquedaEmpleado(carnet);

                if(pocision!=0){
                    System.out.println("Proceso finalizado" +
                            "\nResultado:");
                    matrizEmpleado[pocision].mostrarEmpleado();
                }else{
                    System.out.println("La persona que buscas no existe");
                }
                break;

            //Agregar
            case 2:
                System.out.print("\nIngresa el numero de factura: ");
                carnet = entradaNumerica.nextInt();
                System.out.print("\nIngresa el nombre de la persona que deseas agregar: ");
                nombre = entradaTexto.nextLine();
                nombre = entradaTexto.nextLine();
                System.out.print("\nIngresa el apellido de la persona que deseas agregar: ");
                apellido = entradaTexto.nextLine();
                System.out.print("\nIngresa el edad de la persona que deseas agregar: ");
                edad = entradaNumerica.nextInt();
                System.out.print("\nIngresa el precio de la persona que deseas agregar: ");
                precio = entradaNumerica.nextDouble();

                System.out.println("\nProcesando...");

                pocision = busquedaEmpleado(carnet);

                if(pocision==0){
                    for(int i = 0; i < matrizEmpleado.length; i++){
                        copiaEmpleado[i] = matrizEmpleado[i];
                    }

                    matrizEmpleado = new Empleado[copiaEmpleado.length+1];

                    for (int i = 0; i < matrizEmpleado.length; i++){
                        if(i==(matrizEmpleado.length-1)){
                            matrizEmpleado[i] = new Empleado(nombre, apellido, edad, carnet, precio);
                        }else{
                            matrizEmpleado[i] = copiaEmpleado[i];
                        }
                    }

                    copiaEmpleado = new Empleado[matrizEmpleado.length];

                    System.out.println("Proceso terminado, se ha agregado con exito");

                }else{
                    System.out.println("\nEstas intentando agregar un empleado existente");
                }

                break;

            //Eliminar
            case 3:
                System.out.print("\nIngresa el empleado que deseas eliminar: ");
                carnet = entradaNumerica.nextInt();
                pocision = busquedaEmpleado(carnet);

                if(pocision==0){
                    System.out.println("\nEl empleado que quieres eliminar no existe");
                }else{

                    copiaEmpleado = new Empleado[matrizEmpleado.length-1];

                    for(int i = 0; i < copiaEmpleado.length; i++){
                        if(i==pocision){
                            continue;
                        }else{
                            copiaEmpleado[i] = matrizEmpleado[i];
                        }
                    }

                    matrizEmpleado = new Empleado[copiaEmpleado.length];

                    for (int i = 0; i < copiaEmpleado.length; i++){
                        matrizEmpleado[i] = copiaEmpleado[i];
                    }

                    System.out.println("\nFelicidades empleado eliminada con exito");
                }
                break;

            //Modificar
            case 4:

                System.out.println("\nQue empleado deseas modificar?");
                carnet = entradaNumerica.nextInt();

                pocision = busquedaEmpleado(carnet);

                if (pocision==0){
                    System.out.println("El empleado que buscas no existe");
                }else{
                    matrizEmpleado[pocision].mostrarEmpleado();
                    System.out.println("\nDeseas modificar este usuario?\n" +
                            "1. Si\n" +
                            "CUALQUIER OTRA RESPUESTA SERA TOMADA COMO NO");
                    modificar = entradaNumerica.nextInt();
                    if (modificar==1){
                        for (int i = 0; i<matrizEmpleado.length; i++){
                            copiaEmpleado[i] = matrizEmpleado[i];
                        }

                        for(int i = 0; i < matrizEmpleado.length; i++){
                            if(i==pocision){
                                System.out.print("\nIngresa el nombre de la persona que deseas modificar: ");
                                nombre = entradaTexto.nextLine();
                                System.out.print("\nIngresa el apellido de la persona que deseas modificar: ");
                                apellido = entradaTexto.nextLine();
                                System.out.print("\nIngresa el edad de la persona que deseas modificar: ");
                                edad = entradaNumerica.nextInt();
                                System.out.print("\nIngresa el precio de la persona que deseas modificar: ");
                                precio = entradaNumerica.nextDouble();
                                matrizEmpleado[i] = new Empleado(nombre, apellido, edad, carnet, precio);
                            }else{
                                matrizEmpleado[i] = copiaEmpleado[i];
                            }
                        }
                    }
                    System.out.println("\nFelicidades, empleado actualizada con exito");
                }
                break;

            //Salir
            case 5:
                System.out.println("\nDe vuelta a nuestro menu principal: \n");
                break;
        }
    }

    //busqueda empleado
    private static int busquedaEmpleado(int carnet){
        int pocision = 0;

        for(int i = 0; i < matrizEmpleado.length; i++){
            if(matrizEmpleado[i].getIdCarnet()==carnet){
                pocision = i;
                break;
            }
        }

        return pocision;
    }

    //ALUMNO || METODOS
    private static void opcionesAlumno(int eleccion){
        //Variables de CLIENTE
        int idAlumno = 0;
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String materia = "";
        double nota = 0.00;
        int pocision = 0;

        //Modificar
        int modificar = 0;

        //Viendo Seleccion de Menu
        switch (eleccion){
            //Visualizar
            case 1:
                System.out.print("\nIngresa el id que deseas visualizar: ");
                idAlumno = entradaTexto.nextInt();
                System.out.println("Procesando...");

                pocision = busquedaAlumno(idAlumno);

                if(pocision!=0){
                    System.out.println("Proceso finalizado" +
                            "\nResultado:");
                    matrizAlumno[pocision].mostrarAlumno();
                }else{
                    System.out.println("La persona que buscas no existe");
                }
                break;

            //Agregar
            case 2:
                System.out.print("\nIngresa el numero de id: ");
                idAlumno = entradaNumerica.nextInt();
                System.out.print("\nIngresa el nombre de la persona que deseas agregar: ");
                nombre = entradaTexto.nextLine();
                nombre = entradaTexto.nextLine();
                System.out.print("\nIngresa el apellido de la persona que deseas agregar: ");
                apellido = entradaTexto.nextLine();
                System.out.print("\nIngresa el edad de la persona que deseas agregar: ");
                edad = entradaNumerica.nextInt();
                System.out.print("\nIngresa el producto de la persona que deseas agregar: ");
                materia = entradaTexto.nextLine();
                System.out.print("\nIngresa el precio de la persona que deseas agregar: ");
                nota = entradaNumerica.nextDouble();

                System.out.println("\nProcesando...");

                pocision = busquedaAlumno(idAlumno);

                if(pocision==0){
                    for(int i = 0; i < matrizAlumno.length; i++){
                        copiaAlumno[i] = matrizAlumno[i];
                    }

                    matrizAlumno = new Alumno[copiaAlumno.length+1];

                    for (int i = 0; i < matrizAlumno.length; i++){
                        if(i==(matrizAlumno.length-1)){
                            matrizAlumno[i] = new Alumno(nombre, apellido, edad, idAlumno, materia, nota);
                        }else{
                            matrizAlumno[i] = copiaAlumno[i];
                        }
                    }

                    copiaAlumno = new Alumno[matrizAlumno.length];

                    System.out.println("Proceso terminado, se ha agregado con exito");

                }else{
                    System.out.println("\nEstas intentando agregar un id existente");
                }

                break;

            //Eliminar
            case 3:
                System.out.print("\nIngresa el numero de id que deseas eliminar: ");
                idAlumno = entradaNumerica.nextInt();
                pocision = busquedaAlumno(idAlumno);

                if(pocision==0){
                    System.out.println("\nEl id que quieres eliminar no existe");
                }else{

                    copiaAlumno = new Alumno[matrizAlumno.length-1];

                    for(int i = 0; i < copiaAlumno.length; i++){
                        if(i==pocision){
                            continue;
                        }else{
                            copiaAlumno[i] = matrizAlumno[i];
                        }
                    }

                    matrizAlumno = new Alumno[copiaAlumno.length];

                    for (int i = 0; i < copiaAlumno.length; i++){
                        matrizAlumno[i] = copiaAlumno[i];
                    }

                    System.out.println("\nFelicidades id eliminado con exito");
                }
                break;

            //Modificar
            case 4:

                System.out.println("\nQue id deseas modificar?");
                idAlumno = entradaNumerica.nextInt();

                pocision = busquedaAlumno(idAlumno);

                if (pocision==0){
                    System.out.println("\nEl id que buscas no existe");
                }else{
                    matrizAlumno[pocision].mostrarAlumno();
                    System.out.println("\nDeseas modificar este usuario?\n" +
                            "1. Si\n" +
                            "CUALQUIER OTRA RESPUESTA SERA TOMADA COMO NO");
                    modificar = entradaNumerica.nextInt();
                    if (modificar==1){
                        for (int i = 0; i<matrizAlumno.length; i++){
                            copiaAlumno[i] = matrizAlumno[i];
                        }

                        for(int i = 0; i < matrizAlumno.length; i++){
                            if(i==pocision){
                                System.out.print("\nIngresa el nombre de la persona que deseas Modificar: ");
                                nombre = entradaTexto.nextLine();
                                System.out.print("\nIngresa el apellido de la persona que deseas Modificar: ");
                                apellido = entradaTexto.nextLine();
                                System.out.print("\nIngresa el edad de la persona que deseas Modificar: ");
                                edad = entradaNumerica.nextInt();
                                System.out.print("\nIngresa el producto de la persona que deseas Modificar: ");
                                materia = entradaTexto.nextLine();
                                System.out.print("\nIngresa el precio de la persona que deseas Modificar: ");
                                nota = entradaNumerica.nextDouble();
                                matrizAlumno[i] = new Alumno(nombre, apellido, edad, idAlumno, materia, nota);
                            }else{
                                matrizAlumno[i] = copiaAlumno[i];
                            }
                        }
                    }
                    System.out.println("\nFelicidades, id actualizado con exito");
                }
                break;

            //Salir
            case 5:
                System.out.println("\nDe vuelta a nuestro menu principal: \n");
                break;
        }
    }

    //busqueda alumno
    private static int busquedaAlumno(int carnet){
        int pocision = 0;

        for(int i = 0; i < matrizEmpleado.length; i++){
            if(matrizEmpleado[i].getIdCarnet()==carnet){
                pocision = i;
                break;
            }
        }

        return pocision;
    }

    //Metodo principal
    public static void main(String [] args){
        matrizCliente[0] = new Cliente("Abraham", "Mejicanos", 19, 0, "Papas", 20.50);
        matrizEmpleado[0] = new Empleado("Abraham", "Mejicanos", 19, 0, 20.50);
        matrizAlumno[0] = new Alumno("Abraham", "Mejicanos", 19, 0, "Programacion", 100);

        int respuestaMenuPrincipal = 0;
        int respuestaOpciones = 0;

        //Ejecucion Continua
        while(respuestaMenuPrincipal!=4){
            //Opcion de menu principal
            respuestaMenuPrincipal = menu();
            //Opcion de sub menu
            respuestaOpciones = eleccionOpcion();


            //Cliente
            if(respuestaMenuPrincipal==1){
                //Entrada a metodos
                opcionesCliente(respuestaOpciones);

            //Empleado
            }else if(respuestaMenuPrincipal==2){
                opcionesEmpleado(respuestaOpciones);
            //Alumno
            }else if(respuestaMenuPrincipal==3){

            //Salir
            }else if(respuestaMenuPrincipal==4){
                System.out.println("\nGracias por tu atencion, hasta pronto");
            }
        }
    }
}

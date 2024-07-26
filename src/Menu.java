import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;
    Cursos2 Programacion = new Cursos2("Programacion",012 );
    Cursos2 Calculo = new Cursos2("Calculo", 013);
    Cursos2 Fisica = new Cursos2("Fisica", 011);
    Cursos2 Logica = new Cursos2("Logica en Sistemas", 005);
    Cursos2 Estadistica = new Cursos2 ("Estadistica", 454);
    Cursos2 DerechoInformatico = new Cursos2("Derecho Informático", 222);
    Cursos2 Emprendedores = new Cursos2("Emprendedores de Negocios", 789);

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();

    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedrático");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedrático");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Mostrar Catedráticos");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    registrarCatedratico(scanner);
                    break;
                case 3:
                    inscribirAlumnoEnCurso(scanner);
                    break;
                case 4:
                    asignarCursoACatedratico(scanner);
                    break;
                case 5:
                    mostrarAlumnos();
                    break;
                case 6:
                    mostrarCatedraticos();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private void registrarAlumno(Scanner scanner) {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Alumno: ");
        String id = scanner.nextLine();
        System.out.print("Carrera del Alumno: ");
        String carrera = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno registrado exitosamente.\n");
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Catedrático: ");
        String id = scanner.nextLine();
        System.out.print("Profesion del Catedrático: ");
        String profesion = scanner.nextLine();

        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedrático registrado exitosamente.\n");
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Ingresa tu nombre: ");
        String nombreAlumno = scanner.nextLine();

        System.out.println("¿En qué semestre deseas asignarte un curso?");
        System.out.println("1. Semestre 1");
        System.out.println("2. Semestre 2");
        System.out.println("3. Semestre 3");
        int opcionSemestre = scanner.nextInt();
        scanner.nextLine();


        if (opcionSemestre == 1) {
            System.out.println("Los Cursos que puedes llevar son:");
            List<Cursos2> semestre1 = new ArrayList<>();
            semestre1.add(Programacion);
            semestre1.add(Calculo);
            semestre1.add(Fisica);
            System.out.println("Semestre 1:");
            for (Cursos2 curso : semestre1) {
                System.out.println(curso.getNombre());
            }

            System.out.print("Nombre del Curso que Desea Asignarse: ");
            String nombreCurso = scanner.nextLine();
            boolean cursoValido = false;
            for (Cursos2 curso : semestre1) {
                if (curso.getNombre().trim().toLowerCase().equals(nombreCurso)) {
                    cursoValido = true;
                    break;
                }
            }

            if (!cursoValido) {
                System.out.println("Error: El nombre del curso ingresado no es válido.");
                return;
            }
            System.out.print("Código del Curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = new Curso(nombreCurso, codigoCurso);
            alumnos.get(numAlumno).inscribirCurso(curso);
            cursos.add(curso);

        } else if (opcionSemestre == 2) {
            System.out.print("Ingresa tu Promedio TotaL que tuviste en tu Primer Semestre: ");
            double promedioAlumno = scanner.nextDouble();
            scanner.nextLine();
            if (promedioAlumno < 70) {
                System.out.println("No puedes inscribirte en el Semestre 2. Necesitas un promedio de al menos 70.");
                return;
            }

            System.out.println("Los Cursos que puedes llevar son:");
            List<Cursos2> semestre2 = new ArrayList<>();
            semestre2.add(Logica);
            semestre2.add(Estadistica);
            System.out.println("Semestre 2:");
            for (Cursos2 curso : semestre2) {
                System.out.println(curso.getNombre());
            }

            System.out.print("Nombre del Curso que Desea Asignarse: ");
            String nombreCurso = scanner.nextLine().trim().toLowerCase();
            boolean cursoValido = false;
            for (Cursos2 curso : semestre2) {
                if (curso.getNombre().trim().toLowerCase().equals(nombreCurso)) {
                    cursoValido = true;
                    break;
                }
            }

            if (!cursoValido) {
                System.out.println("Error: El nombre del curso ingresado no es válido.");
                return;
            }
            System.out.print("Código del Curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = new Curso(nombreCurso, codigoCurso);
            alumnos.get(numAlumno).inscribirCurso(curso);
            Alumno alumno = new Alumno(nombreAlumno, promedioAlumno);
            cursos.add(curso);

        } else if (opcionSemestre == 3) {
            System.out.print("Ingresa tu Promedio TotaL que tuviste en tu Segundo Semestre: ");
            double promedioAlumno = scanner.nextDouble();
            scanner.nextLine();
            if (promedioAlumno < 75) {
                System.out.println("No puedes inscribirte en el Semestre 3. Necesitas un promedio de al menos 75.");
                return;
            }

            System.out.println("Los Cursos que puedes llevar son:");
            List<Cursos2> semestre3 = new ArrayList<>();
            semestre3.add(DerechoInformatico);
            semestre3.add(Emprendedores);

            System.out.println("Semestre 3:");
            for (Cursos2 curso : semestre3) {
                System.out.println(curso.getNombre());
            }

            System.out.print("Nombre del Curso que Desea Asignarse: ");
            String nombreCurso = scanner.nextLine();
            boolean cursoValido = false;
            for (Cursos2 curso : semestre3) {
                if (curso.getNombre().trim().toLowerCase().equals(nombreCurso)) {
                    cursoValido = true;
                    break;
                }
            }

            if (!cursoValido) {
                System.out.println("Error: El nombre del curso ingresado no es válido.");
                return;
            }
            System.out.print("Código del Curso: ");
            String codigoCurso = scanner.nextLine();

            Curso curso = new Curso(nombreCurso, codigoCurso);
            alumnos.get(numAlumno).inscribirCurso(curso);
            Alumno alumno = new Alumno(nombreAlumno, promedioAlumno);
            cursos.add(curso);

        } else {
            System.out.println("Opción Incorrecta");
        }

    }



    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        catedraticos.get(numCatedratico).asignarCurso(curso);
        cursos.add(curso);
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
        } else {
            System.out.println("----- Lista de Alumnos -----");
            for (Alumno alumno : alumnos) {
                alumno.mostrarDetalles();
            }
            System.out.println();
        }
    }

    private void mostrarCatedraticos() {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
        } else {
            System.out.println("----- Lista de Catedráticos -----");
            for (Catedratico catedratico : catedraticos) {
                catedratico.mostrarDetalles();
            }
            System.out.println();
        }
    }

}

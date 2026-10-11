// Taller POO JESUS ADRIAN RUIZ GONZALEZ - Veterinaria Patas del Magdalena
// Encapsulamiento y arreglos de objetos

class Mascota {
    private String nombre;
    private String especie;
    private double peso;
    private int edad;

    Mascota(String nombre, String especie, double peso, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
    }

    // gets: puertas de salida, solo dejan mirar el dato
    String getNombre() {
        return nombre;
    }

    String getEspecie() {
        return especie;
    }

    double getPeso() {
        return peso;
    }

    int getEdad() {
        return edad;
    }

    // sets: puertas de entrada, revisan antes de guardar
    void setPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            System.out.println("RECHAZADO: no puede pesar " + nuevoPeso + " kg");
            return;
        }
        this.peso = nuevoPeso;
    }

    void setEdad(int nuevaEdad) {
        if (nuevaEdad < 0) {
            System.out.println("RECHAZADO: no puede tener " + nuevaEdad + " años");
            return;
        }
        this.edad = nuevaEdad;
    }

    int valorConsulta() {
        int valor = 35000;
        if (peso > 25) {
            valor = 55000;
        } else if (peso > 10) {
            valor = 45000;
        }
        // si ademas tiene 8 años o mas, se suman 12000 al valor que haya dado
        if (edad >= 8) {
            valor = valor + 12000;
        }
        return valor;
    }

    String descripcion() {
        return nombre + " (" + especie + ", " + peso + " kg, " + edad + " años)";
    }
}

public class Veterinaria {
    public static void main(String[] args) {

        Mascota[] pacientes = new Mascota[4];
        pacientes[0] = new Mascota("Luna", "Perro", 28.5, 9);
        pacientes[1] = new Mascota("Michi", "Gato", 4.2, 3);
        pacientes[2] = new Mascota("Rocky", "Perro", 12.0, 5);
        pacientes[3] = new Mascota("Pepa", "Conejo", 2.1, 1);

        int total = 0;

        for (int i = 0; i < pacientes.length; i++) {
            Mascota m = pacientes[i];
            if (m != null) {
                System.out.println(m.descripcion() + " paga " + m.valorConsulta());
                total = total + m.valorConsulta();
            }
        }

        System.out.println("TOTAL RECAUDADO: " + total);

        // intento de dejar a Michi con peso negativo, el set lo debe rechazar
        pacientes[1].setPeso(-3);
        System.out.println(pacientes[1].descripcion());
    }
}

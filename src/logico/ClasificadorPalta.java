package logico;

import datos.*;
import java.util.*;

/**
 *
 * @author Oscar
 */
public class ClasificadorPalta {

    private ArrayList<Palta> paltas;
    private ArrayList<String[]> datosPaltas;

    public ClasificadorPalta() {
        Lector lector = new Lector();
        this.datosPaltas = lector.getDatos();
        this.paltas = new ArrayList<Palta>();
        this.clasificarPaltas();
    }

    private void clasificarPaltas() {
        for (int i = 0; i < this.datosPaltas.size(); i++) {
            String[] date = this.datosPaltas.get(i)[1].split("-");
            int[] fechas = {Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])};
            Date fecha = new Date(fechas[0] - 1900, fechas[1] - 1, fechas[2]);
            double averagePrice = Double.parseDouble(this.datosPaltas.get(i)[2]);
            double totalVolume = Double.parseDouble(this.datosPaltas.get(i)[3]);
            double plu4046 = Double.parseDouble(this.datosPaltas.get(i)[4]);
            double plu4225 = Double.parseDouble(this.datosPaltas.get(i)[5]);
            double plu4770 = Double.parseDouble(this.datosPaltas.get(i)[6]);
            double totalBags = Double.parseDouble(this.datosPaltas.get(i)[7]);
            double smallBags = Double.parseDouble(this.datosPaltas.get(i)[8]);
            double largeBags = Double.parseDouble(this.datosPaltas.get(i)[9]);
            double xLargeBags = Double.parseDouble(this.datosPaltas.get(i)[10]);
            String type = this.datosPaltas.get(i)[11];
            int year = Integer.parseInt(this.datosPaltas.get(i)[12]);
            String region = this.datosPaltas.get(i)[13];
            this.paltas.add(new Palta(fecha, averagePrice, totalVolume, plu4046, plu4225, plu4770, totalBags, smallBags, largeBags, xLargeBags, type, year, region));

        }

    }
    // Para devolver sus datos se tendrá que devolver el objeto por simplicidad

    public Palta obtenerPrecioBajo() {
        Comparator<Palta> paltaBarata = Comparator.comparing(Palta::getAveragePrice);
        Collections.sort(this.paltas, paltaBarata);
        return this.paltas.get(0);
    }

    // No se pueden mostrar las paltas como tal, entonces se mostrarán sus atributos
    public void listaPrecios(int lugares) {
        Comparator<Palta> paltaBarata = Comparator.comparing(Palta::getAveragePrice);
        Collections.sort(this.paltas, paltaBarata);
        if (this.paltas.size() >= lugares) {
            String titulo = "  Date                         Average Price  Total volume   plu4046    plu4225   plu4770 Total Bags Small Bags  Large Bags  xLarge Bags       Type       Year   Region";
            System.out.println(titulo);
            for (int i = 0; i < lugares; i++) {
                this.paltas.get(i).mostrarEstadisticas();
            }
        } else {
            System.out.println("Ha sobrepasado el máximo de lugares disponibles");
        }
    }

    public ArrayList obtenerPorAño(int año) {
        ArrayList<Palta> paltasAño = new ArrayList<Palta>();
        for (int i = 0; i < this.paltas.size(); i++) {
            if (this.paltas.get(i).getYear() == año) {
                paltasAño.add(this.paltas.get(i));
            }
        }
        return paltasAño;
    }

    // Encabezado del método no es igual a su descripción, se obtendrá las paltas entre un intervalo de años y se retornará un arraylist con las paltas
    public ArrayList obtenerIntervaloAño(int año1, int año2) {
        ArrayList<Palta> paltasAño = new ArrayList<Palta>();
        for (int i = 0; i < this.paltas.size(); i++) {
            if (this.paltas.get(i).getYear() >= año1 || this.paltas.get(i).getYear() <= año2) {
                paltasAño.add(this.paltas.get(i));
            }
        }
        return paltasAño;
    }

    public ArrayList obtenerPorIntervaloPrecio(int precio1, int precio2) {
        ArrayList<Palta> paltasPrecio = new ArrayList<Palta>();
        for (int i = 0; i < this.paltas.size(); i++) {
            if (this.paltas.get(i).getAveragePrice() >= precio1 || this.paltas.get(i).getAveragePrice() <= precio2) {
                paltasPrecio.add(this.paltas.get(i));
            }
        }
        return paltasPrecio;

    }

    public ArrayList obtenerPorRegion(String region) {
        ArrayList<Palta> paltasRegion = new ArrayList<Palta>();
        for (int i = 0; i < this.paltas.size(); i++) {
            if (this.paltas.get(i).getRegion().equals(region)) {
                paltasRegion.add(this.paltas.get(i));
            }
        }
        return paltasRegion;
    }

    public ArrayList obtenerPorTipo(String tipo) {
        ArrayList<Palta> paltasTipo = new ArrayList<Palta>();
        for (int i = 0; i < this.paltas.size(); i++) {
            if (this.paltas.get(i).getType().equals(tipo)) {
                paltasTipo.add(this.paltas.get(i));
            }
        }
        return paltasTipo;

    }

    public void sortPrecio() {
        Comparator<Palta> paltaBarata = Comparator.comparing(Palta::getAveragePrice);
        Collections.sort(this.paltas, paltaBarata);
    }

    public void sortAño() {
        Comparator<Palta> paltaAño = Comparator.comparing(Palta::getYear);
        Collections.sort(this.paltas, paltaAño);
    }

    public void sortTipo() {
        Comparator<Palta> paltaTipo = Comparator.comparing(Palta::getType);
        Collections.sort(this.paltas, paltaTipo);
    }

    public void mostrarEstadisticasPaltas(int cantidad) {
        if (cantidad > this.paltas.size()) {
            cantidad = this.paltas.size();
        }
        String titulo = "  Date                         Average Price  Total volume   plu4046    plu4225   plu4770 Total Bags Small Bags  Large Bags  xLarge Bags       Type       Year   Region";
        System.out.println(titulo);
        for (int i = 0; i < cantidad; i++) {
            this.paltas.get(i).mostrarEstadisticas();
        }
    }

}

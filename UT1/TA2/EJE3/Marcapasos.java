/*
Un marcapasos debe funcionar consumiendo la menor cantidad de energía posible y ser lo
más barato posible, por lo que incluye una mínima cantidad de memoria.
Con sus sensores obtiene continuamente las siguientes medidas, con los rangos que se
indican:
• Presión Sanguínea (0-250)
• Frecuencia cardíaca (0-226)
• Nivel de azúcar en sangre. (0 - 1000).
Además, para autodiagnóstico mantiene un registro de:
• Máxima fuerza a la que fue expuesto (0-3.000.000.000).
• Mínimo tiempo entre latidos (0-100 con decimales).
• Batería restante. (% de batería restante con decimales con la mayor precisión
posible).
• Código del Fabricante (Números y letras, máximo 8 caracteres).
Trabajo a realizar:
a) Crear una clase "Marcapasos" que contenga variables para almacenar esta
información. Utilice los tipos de datos primitivos de java teniendo en cuenta que se
quiere consumir la menor cantidad de memoria posible.
b) Calcular cuánta memoria consume un objeto de su clase (considerando solamente el
espacio ocupado por las variables indicadas).
c) Remit el Código JAVA y el resultado de todos los cálculos en un archivo “PD8.zip” a la
tarea correspondiente de Ejercicios Domiciliarios.
 */

public class Marcapasos {
    // variables para guardar la info del marcapasos
    private byte presionSanguinea; // presion sanguínea entre 0-250 (1 byte)
    private byte frecuenciaCardiaca; // frecuencia cardiaca entre 0-226 (1 byte)
    private short nivelAzucar; // nivel de azucar entre 0-1000 (2 bytes)
    private int maxFuerza; // máxima fuerza entre 0-3,000,000,000 (4 bytes)
    private float minTiempoLatidos; // tiempo mínimo entre latidos, puede tener decimales (4 bytes)
    private double bateriaRestante; // batería restante en porcentaje, con decimales (8 bytes)
    private String codigoFabricante; // código del fabricante, máximo 8 caracteres (4 bytes para la referencia + 8 bytes para los caracteres)



    // Constructor para inicializar las variables
    public Marcapasos(byte presionSanguinea, byte frecuenciaCardiaca, short nivelAzucar,
                      int maxFuerza, float minTiempoLatidos, double bateriaRestante, String codigoFabricante) {
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucar = nivelAzucar;
        this.maxFuerza = maxFuerza;
        this.minTiempoLatidos = minTiempoLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }

    // cuánto ocupa un objeto de esta clase en memoria
    // presionSanguinea: 1 byte
    // frecuenciaCardiaca: 1 byte
    // nivelAzucar: 2 bytes
    // maxFuerza: 4 bytes
    // minTiempoLatidos: 4 bytes
    // bateriaRestante: 8 bytes
    // codigoFabricante: 4 bytes (referencia) + 8 bytes (8 caracteres)
    // total sin contar el overhead del objeto: 1 + 1 + 2 + 4 + 4 + 8 + 4 + 8 = 32 bytes
    // el overhead en un objeto en Java es como 12-16 bytes en 64 bits.
    // entonces, en total, el objeto puede ocupar entre 44-48 bytes.

    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.12.2
}

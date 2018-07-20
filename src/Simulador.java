public class Simulador {
    private static long tini=System.currentTimeMillis();
    private static java.util.Random rand= new java.util.Random();
    
    public static void main(String[] args) {
        // Complete aquí la simulación
        Jugador [] jugadoresNovatos= new Jugador[7];
        Jugador [] jugadoresExpertos = new Jugador[7];
        Club club= new Club(20,20);

        for(int i =0;i<7;i++){
            jugadoresNovatos[i]= new Jugador(i,'n',5,club);
            jugadoresExpertos[i]= new Jugador(i,'e',5,club);
        }
        for(int i = 0;i<7;i++){
            jugadoresNovatos[i].start();
            jugadoresExpertos[i].start();
        }

        for(int i = 0;i<7;i++){
            try{
                jugadoresNovatos[i].join();
                jugadoresExpertos[i].join();
            }catch(Exception e){}
        }





        log("Termina Simulador.main");
    }
    
    // Muestra información en la pantalla
    public static void log(String message) {
            long cur=System.currentTimeMillis();
            String t= String.format("%6.1fs      \033[1;33m%s\033[m\n", (cur-tini)/1000.0, message);
            System.out.print(t);
    }
    
    // Devuelve tiempo de juego en milisegundos
    public static int tiempoJuego() {
        return rand.nextInt(1000);
    }
    
    // Devuelve tiempo de descanso en milisegundos
    public static int tiempoDescanso() {
        return rand.nextInt(1000);
    }
}

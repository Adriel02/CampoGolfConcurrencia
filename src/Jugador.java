public class Jugador extends  Thread {


    private int  identificador;
    private char tipo;
    private int repeticiones;
    private Club club;


    private static java.util.Random rand= new java.util.Random();

    public Jugador(int identificador,char tipo, int repeticiones,Club club){
        this.identificador=identificador;
        this.tipo=tipo;
        this.repeticiones=repeticiones;
        this.club=club;
    }

    @Override
    public void run(){
        int palos=0;
        int pelotas=0;
        for(int i = 0;i<repeticiones;i++){
            if(this.tipo=='e'){
                pelotas=1;
                palos=2+rand.nextInt(4);
            }
            if(this.tipo=='n'){
                pelotas= 2+ rand.nextInt(4);
                palos=2;
            }
            club.reservar(""+this.identificador+this.tipo,palos,pelotas);
            try{
                Thread.sleep(Simulador.tiempoJuego());
            }catch(Exception e){}
            club.devolver(""+this.identificador+this.tipo,palos,pelotas);
            try{
                Thread.sleep(Simulador.tiempoDescanso());
            }catch(Exception e){}
        }
    }
}

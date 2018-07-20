public class Club {

    private int pelotas;
    private int palos;

    public Club(int palos, int pelotas){
        this.pelotas=pelotas;
        this.palos=palos;
    }


    public synchronized void reservar(String idUsuario,int palosAlquilar,int pelotasAlquilar){
        System.out.println("El jugador "+idUsuario+" quiere alquilar "+palosAlquilar+" palos y "+ pelotasAlquilar+" pelotas. Quedan "+palos+" palos y "+pelotas+" pelotas en el Club");
        while(pelotasAlquilar>pelotas || palosAlquilar>palos){
            System.out.println("El jugador "+ idUsuario+" no puede jugar. No hay pelotas disponibles");
            try{
                wait();
            }catch(Exception e){}
        }
        pelotas=pelotas-pelotasAlquilar;
        palos=palos-palosAlquilar;
        System.out.println("El jugador alquila "+palosAlquilar+" palos y "+pelotasAlquilar+" pelotas. Quedan "+palos+" palos y "+pelotas+" pelotas en el Club");

    }

    public synchronized void devolver(String idUsuario, int pelotasDevolver, int palosDevolver){
        palos=palos+palosDevolver;
        pelotas=pelotas+pelotasDevolver;
        notifyAll();
        System.out.println("El jugador "+idUsuario+" devuelve "+palosDevolver+" palos y "+pelotasDevolver+" pelotas. Quedan "+palos+" palos y "+pelotas+" pelotas en el Club");
    }
}

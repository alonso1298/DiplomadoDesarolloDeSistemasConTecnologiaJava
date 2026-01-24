package dgtic.core.modelo;

public class FabricaCoches {
    private static FabricaCoches fabricaCoches = new FabricaCoches();
    public static FabricaCoches getInstance(){
        return fabricaCoches;
    }
    public IModeloCoche getModeloCoche(TipoCarro tipo) throws IllegalAccessException{
        if (tipo.equals(TipoCarro.DEPORTIVO)){
            return new Deportivo();
        }else if(tipo.equals(TipoCarro.FAMILIAR)){
            return new Familiar();
        }else if(tipo.equals(TipoCarro.TODOTERRENO)){
            return new TodoTerreno();
        }
        throw new IllegalAccessException("No existe el tipo de carro");
    }
}

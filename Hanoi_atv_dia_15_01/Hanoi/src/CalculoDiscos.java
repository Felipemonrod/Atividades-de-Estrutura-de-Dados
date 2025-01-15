class CalculoDiscos {
    long quantidadeDiscos;

    public void resolverHanoi(long quantidade, char origem, char auxiliar, char destino) {
        if (quantidade == 1) {
            // ------ caso queira reduzir o tempo de exec coment a linha abaixo
            System.out.println("Mover disco de " + origem + " para " + destino);
            // ------ 
        } else {
            resolverHanoi(quantidade - 1, origem, destino, auxiliar);
            // ------ caso queira reduzir o tempo de exec coment a linha abaixo
             System.out.println("Mover disco de " + origem + " para " + destino);
            // ------ 
            resolverHanoi(quantidade - 1, auxiliar, origem, destino);
        }
    }
}
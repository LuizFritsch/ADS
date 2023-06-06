class Exercicios {
    public static void main(String[] args) {
       StaticStack<Integer> stackInt = new StaticStack<Integer>(8);
       Queue<Integer> queueInt = new StaticQueue<Integer>(2);
       try {
        for(int i=10, j=0; i>3; i--, j++){
            queueInt.enqueue(j-i);
            stackInt.push(queueInt.dequeue());
            queueInt.enqueue(stackInt.pop()*-1);
        }
       } catch (UnderFlowException e) {
        // TODO: handle exception
        e.printStackTrace();
       }catch(OverFlowException e){
        e.printStackTrace();
       }
       StaticQueue<String> queueStr = new StaticQueue<String>(stackInt.numeElements()+queueInt.numeElements());
       
    }

    

}

public class ResultGen {

    Integer geraResultado (ArvoreSintatica arv){

        if(arv instanceof Mult){
            return geraResultado(((Mult) arv).arg1) * geraResultado(((Mult) arv).arg2);
        }
        if(arv instanceof Soma){
            return geraResultado(((Soma) arv).arg1) + geraResultado(((Soma) arv).arg2);
        }
        if(arv instanceof Sub){
            return geraResultado(((Sub) arv).arg1) - geraResultado(((Sub) arv).arg2);
        }
        if(arv instanceof Div){
            return geraResultado(((Div) arv).arg1) / geraResultado(((Div) arv).arg2);
        }
        if (arv instanceof Num){
            return ((Num) arv).num;
        }
        return null;
    }

}

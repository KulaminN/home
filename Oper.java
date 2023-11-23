public enum Oper {
    SUM {
        @Override
        double operMeth(double arg1, double arg2) {
            return arg1+arg2;
        }
    },
    DIV {
        @Override
        double operMeth(double arg1, double arg2) {
            return arg1/arg2;
        }
    },MUL {
        @Override
        double operMeth(double arg1, double arg2) {
            return arg1*arg2;
        }
    },SUB {
        @Override
        double operMeth(double arg1, double arg2) {
            return arg1-arg2;
        }
    },OST{
        @Override
        double operMeth(double arg1, double arg2) {
            return arg1%arg2;
        }
    }
    ,NONE {
        @Override
        double operMeth(double arg1, double arg2) {
            return 0;
        }
    };
    abstract double operMeth(double arg1, double arg2);

}

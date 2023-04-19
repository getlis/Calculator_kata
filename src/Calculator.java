class Calculator {

    String calc( String _system_numeric_name, String _numbers_and_operator, System_numeric _system_numeric ){
        String operator = this.get_operator( _numbers_and_operator );
        String[] numbers = _numbers_and_operator.split( "[" + operator + "]");

        if ( _system_numeric_name.equals( _system_numeric.arab ) ){
            int x = Integer.parseInt( numbers[0]);
            int y = Integer.parseInt( numbers[1]);
            int result = this.equation( operator, x,y );

            return Integer.toString( result );

        } else if ( _system_numeric_name.equals( _system_numeric.rim ) ) {

            int x = _system_numeric.rim_to_arab.get( numbers[0] );
            int y = _system_numeric.rim_to_arab.get( numbers[1] );


            int result = this.equation( operator, x,y );


            if (result <=0 ){ throw new IllegalStateException("Результат в римской системе счисления, результат не может быть отрицательным или равным 0."); }
            else if ( result > 100 ){ throw new IllegalStateException("TODO");  }
            else{ return _system_numeric.arab_to_rim.get( result ); }

        } else{ return operator; }
    }

    int equation( String _operator, int _value_x, int _value_y ) {

        return switch (_operator) {
            case "+" -> _value_x + _value_y;
            case "-" -> _value_x - _value_y;
            case "*" -> _value_x * _value_y;
            case "/" -> _value_x / _value_y;
            default -> throw new IllegalStateException("Unexpected value: " + _operator);
        };

    }
    String get_operator( String _line ){
        if (_line.indexOf('+') >0 ){ return "+";}
        else if (_line.indexOf('-') >0 ){ return "-";}
        else if (_line.indexOf('*') >0 ){ return "*";}
        else if (_line.indexOf('/') >0 ){ return "/";}
        else return "error";
    }

}

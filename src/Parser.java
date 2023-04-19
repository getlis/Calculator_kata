class Parser {

    System_numeric system_numeric;

    Parser( System_numeric _system_numeric ){
        this.system_numeric = _system_numeric;
    }

    String[] line_prepare(String line ){
        // Подготовка
        String[] arr_line = {"",""}; // система, модифицированная строка

        if( line != null && !line.equals("") ){ // строка не пустая
            line = line.toUpperCase(); // переводим все в верхний регистр
            line = line.replaceAll("[ \t\n\r]", ""); // удаляем пустоты

            if ( line.length() >= 3 && line.length() <= 9 ) {//проверка длины - миним 1+1 (3), максим viii+viii (9)

                if ( line.matches( system_numeric.arab_regexp ) ){ // определяем сисетму счисления ар.
                    arr_line[0] = system_numeric.arab;
                    arr_line[1] = line;


                } else if ( line.matches( system_numeric.rim_regexp ) ) {  // определяем сисетму счисления рим.
                    arr_line[0] = system_numeric.rim;
                    arr_line[1] = line;


                } else {
                    String msg = "Необходимы 2 операнда с одной системы счисления. Арабские (1-10) или римские (I-X). А так же, 1 оператор (+-/*) между операндами.";
                    throw new IllegalStateException( msg );
                }
            } else {

                String msg = "Строка не является математической операцией.";
                throw new IllegalStateException( msg );
            }
        } else {
            String msg = "Строка не является математической операцией.";
            throw new IllegalStateException( msg );
        }

        return arr_line;
    }
}

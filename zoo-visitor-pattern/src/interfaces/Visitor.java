package interfaces;

import employees.*;

public interface Visitor<T> {
    T visit(Ksiegowy k);

    T visit(Przewodnik p);

    T visit(Opiekun o);

    T visit(Kierownik k);

    T visit(AsystentKierownika a);

    T visit(Weterynarz w);

    T visit(Magazynier m);
}

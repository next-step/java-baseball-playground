package study;

import java.util.Objects;

public class CaseInsensitiveString {
    public final String s;
    public CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
        }
        if (o instanceof String){
            return s.equalsIgnoreCase((String) o);
        }

        return true;
    }
}

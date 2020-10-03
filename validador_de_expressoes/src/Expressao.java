public class Expressao {
    static boolean result;

    static boolean teste(String expressao) {
        Pilha pilha = new Pilha(expressao.length());
        char[] ch = new char[expressao.length()];
        for (int i = 0; i < expressao.length(); i++) {
            ch[i] = expressao.charAt(i);
            if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
                pilha.empilha(ch[i]);
            }
            else if (ch[i] == '}' || ch[i] == ')' || ch[i] == ']') {
                switch (ch[i]) {
                    case '}':
                        if (ch[i-1] != '{') return false;
                        else {
                            pilha.desempilha(ch[i-1]);
                        }
                    case ')':
                        if (ch[i - 1] != '(') return false;
                        else {
                            pilha.desempilha(ch[i - 1]);
                        }
                    case ']':
                        if (ch[i - 1] != '[') return false;
                        else {
                            pilha.desempilha(ch[i - 1]);
                        }
                }
            }
            else continue;
        }
        if (pilha.vazia()) {
            result = true;
        }
        if (pilha.cheia()) {
            result = false;
        }
    return result;
    }

    public static void main(String[] args) {
        System.out.println(teste("{{()}}"));
    }
}



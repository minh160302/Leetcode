class TextEditor {
    StringBuilder sb;
    int cursor; 

    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sb.insert(cursor, text);
        cursor += text.length();
    }
    
    public int deleteText(int k) {
        int cnt = 0;
        while (cursor > 0 && k > 0) {
            sb.deleteCharAt(cursor - 1);
            cursor--;
            k--;
            cnt++;
        }
        return cnt;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return sb.substring(Math.max(cursor - 10, 0), cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(sb.length(), cursor + k);
        return sb.substring(Math.max(cursor - 10, 0), cursor);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
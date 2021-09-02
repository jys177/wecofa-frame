package wecofa.frame.batch.chunk.writer.callback;

public interface ItemStruct {
    

    public String getLineFromItemStruct();
    /**
     * 처음 설정한 Length 와 같은지 확인
     * */
    public boolean validateItemLine(String itemLine, int totalLen);

}

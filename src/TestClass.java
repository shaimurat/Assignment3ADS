class TestClass {
    private String key;

    public TestClass(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int h = 17;
        for(int i = 0;i<key.length();i++) {
            h = h * 17 + key.charAt(i);
        }

        return h;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "key='" + key + '\'' +
                '}';
    }
}

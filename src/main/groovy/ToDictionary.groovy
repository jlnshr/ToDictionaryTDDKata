class ToDictionary {

    static HashMap<String, String> toDictionary(String input) {
        HashMap<String, String> dictionary = new HashMap<>()
        if (input.isEmpty() || !input.contains("=")) {
            return dictionary
        }
        if (input.startsWith("=")) {
            throw new IllegalArgumentException("Invalid input!")
        }
        String[] inputArr = input.split(";")
        for (String s : inputArr) {
            if(s.isEmpty()){
                continue
            }
            def (String key, String value) = extractKeyAndValue(s)
            dictionary.put(key, value)
        }
        return dictionary
    }

    private static List extractKeyAndValue(String s) {
        String key = s.substring(0, s.indexOf("="))
        String value = s.substring(s.indexOf("=") + 1)
        [key, value]
    }
}

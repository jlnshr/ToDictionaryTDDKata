import spock.lang.Specification

class ToDictionarySpec extends Specification {

    def "Check thath toDictionary works with empty String"() {
        given: "A String input"
        String input = ""

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect result to have 1 entry with key 'a' and value '1'"
        result.size() == 0
    }

    def "Check that toDictionary works as intended with input 'a=1'"() {
        given: "A String input"
        String input = "a=1"

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect result to have 1 entry with key 'a' and value '1'"
        result.size() == 1
        result.get("a") == "1"
    }

    def "Check that toDictionary works as intended with input 'a=1;b=2;c=3'"() {
        given: "A String input"
        String input = "a=1;b=2;c=3"

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect 3 entries with corresponding values"
        result.size() == 3
        result.get(key) == value

        where:
        key | value
        "a" | "1"
        "b" | "2"
        "c" | "3"
    }

    def "Check that toDictionary works as intended with input 'a=1;a=2'"() {
        given: "A String input"
        String input = "a=1;a=2"

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect result to have 1 entry with key 'a' and value '2'"
        result.size() == 1
        result.get("a") == "2"
    }

    def "Check that toDictionary works as intended with input 'a==1'"() {
        given: "A String input"
        String input = "a==1"

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect result to have 1 entry with key 'a' and value '=1'"
        result.size() == 1
        result.get("a") == "=1"
    }

    def "Check that toDictionary works as intended with input '=1'"() {
        given: "A String input"
        String input = "=1"

        when: "Calling toDictionary"
        ToDictionary.toDictionary(input)

        then: "Expect an IllegalArgumentException"
        thrown(IllegalArgumentException)
    }

    def "Check that toDictionary works as intended with input 'a='"() {
        given: "A String input"
        String input = "a="

        when: "Calling toDictionary"
        HashMap<String, String> result = ToDictionary.toDictionary(input)

        then: "Expect result to have 1 entry with key 'a' and value ''"
        result.size() == 1
        result.get("a") == ""
    }
}
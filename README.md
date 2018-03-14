## ToDictionary

Write a function that converts a specially formatted String into a dictionary.

The function should have the following signature:

`IDictionary<string, string> ToDictionary(string input);`

The following table shows sample input Strings and the resulting dictionary

| Input             | Output                               |
| :----------------:|:------------------------------------:|
| "a=1;b=2;c=3      | `{{"a", "1"}, {"b" "2"}, {"c", "3"}}`|
| "a=1;a=2"         | `{{"a", "2"}}`                       |
| "a=1;;b=2"        | `{{"a", "1"}, {"b", "2"}`            |
| "a="              | `{{"a", ""}}`                        |
| "=1"              | `Exception`                          |
| ""                | `{{ }}`                              |
| "a==1"            | `{{"a", "=1"}}`                      |


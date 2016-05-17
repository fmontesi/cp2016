# Exam Instructions

To pass the course, you have to prepare a software project and a written report
on it. Everything has to be uploaded as a single zip file containing the following:
- `report.pdf`: this is the written report.
- `code`: a directory containing all source code of the software project.

Detailed instructions on the two items are given below.

## Hand-in

An assignment will be opened on Blackboard for handing in the project. The deadline for uploading the project on Blackboard will be: 25 April 2016 at midnight.

## Report

The report must be written in English and be at the most 3 page long.

Use 1.5 line spacing and ensure that the page margins are at least of 2cm (in all directions).
For the body text, use Times new roman as family and at least 11pt as font size.

In the first page, you must state
the name of the course, your name, your e-mail address, and the date (in which
you last edited the document). The report must contain the following sections:
- Methodology. Here you explain how you designed your software. Give a brief
  overview of how it works and then focus on how you handle concurrency.
  For example, did you use futures, executors, manual control over threads,
  and/or monitors? How did you use them?
- Advantages. Here you explain the nice points of your implementation, i.e.,
  the advantages that come out of your design choices.
- Limitations. Here you explain the limitations of your approach and, possibly,
  how they could be overcome. Did you sacrifice performance for achieving better
  readability of your code? Or, did you sacrifice readability for improving
  efficiency? Is there a way to improve how you coordinate concurrent computation?

Inspiration points to discuss advantages and
limitations:
- Readability
- Speed
- Memory consumption
- Reusability (the code can be reused in different contexts)
- Scalability (scales well with the number of cores, or amount of memory)
- Reliability (handling of errors/exceptions)

## Software project

The `code` subdirectory in the zip file must contain a `wordfinder` subdirectory that implements the `WordFinder` class found in this directory (see `WordFinder` in the subdirectory `wordfinder/src/cp`).
To be sure that you are getting the class names and method signatures right, copy the `wordfinder` subdirectory from this repository and start from there. Concretely, you must implement the methods `findAll`, `findAny` and `stats` in class `WordFinder`.
The class contains documentation about what these methods are supposed to do.

The most important evaluation criterion for the project is how well concurrency is managed in the program. Handing in a project that does not use concurrency is an automatic fail!

I suggest that you use the [NetBeans IDE](https://netbeans.org/) to develop the project. The easiest way is to follow the steps below:
- Open the project `wordfinder` that you have just copied in your filesystem.
- Edit method `main` in class `Main` to test the methods you have implemented in `WordFinder`. Your code in `Main.main` will be completely disregarded in the evaluation. Only the implementation of `WordFinder` will be evaluated.

Using NetBeans is an easy way to ensure that I will be able to compile your code correctly. If the code does not compile the exam is automatically failed, so make sure that it does!


# Frequently Asked Questions and Comments

- Will there be a high score ladder? Yes, of course!

- What version of NetBeans should we use? Use at least version 8.

- The project will be tested using Java 8.

- Only text files should be looked into for searching words.
A text file is a file ending with the `.txt` suffix.

- Including external libraries is forbidden.
You can only use the Java standard library.

- Be careful: when I measure the time it takes your method calls to terminate, having threads that have not terminated may slow down the measurement.

- `findAll`:
  * If the same word appears more than once in the same file, then there should be a Result for each occurrence (even if the occurrences are on the same line).
  * Parameter `word` is never a sentence: it does not contain whitespaces (spaces, tabs, newlines, more specifically the `\s` class in regular expressions in Java) but may contain punctuation.
  * The word must be an exact match: it is case-sensitive and may contain punctuation. So, for example: "hi," is not a valid occurrence of "hi"; "hi," is a valid occurrence of "hi,"; ".hi" is a valid occurrence of ".hi" but not "hi"; "word-word" is a valid instance of "word-word", and therefore it cannot count for "word". This does not mean that the word is necessarily between whitespaces, for example it could appear at the beginning or end of a file.

- `stats`:
  * If multiple words are the least frequently appearing (or the most frequently appearing), you can return any one of them in `leastFrequent` (respectively `mostFrequent`).
  * The method is case-sensitive, as the others.
  * Words can contain punctuation. A word is what you would get as an element by splitting a line by whitespacing, for example: `line.split( "\\s+" )`. So, for example, "hi," is a word.

- How do I traverse directories?
There are different ways to traverse directories in Java. See: [http://www.adam-bien.com/roller/abien/entry/listing_directory_contents_with_jdk](http://www.adam-bien.com/roller/abien/entry/listing_directory_contents_with_jdk) and [https://docs.oracle.com/javase/tutorial/essential/io/walk.html](https://docs.oracle.com/javase/tutorial/essential/io/walk.html). There is no "best" way for the project, since maybe one way will play nicer than the others with how you intend to program concurrency. You can also see the (simple!) example in `lectures`.

- How do I get test data?
Open [https://www.github.com/](https://www.github.com/) and find a software project full of source files, for example [https://github.com/dthree/cash](https://github.com/dthree/cash). Download the project, for example by executing `git clone https://github.com/dthree/cash`. Rename lots of text files such that they have a `.txt` suffix, for example by running: `find . -name "*.js" -exec bash -c 'mv "$1" "$(sed "s/\.js$/.txt/" <<< "$1")"' - '{}' \;`. You now have a directory full of (probably small) text files. To add some big files, go to [http://www.lipsum.com/](http://www.lipsum.com/), generate a big chunk of text and create a file with multiple copies of it. (I recommend reaching at least 50MB or similar, but feel free to go higher!)

- How many cores will be used in the evaluation?
Different set-ups will be used: 1 core, 2 cores, 3 cores, 4 cores. So your project should adapt to the number of cores available on the machine. The same CPU will always be used.

- What about the storage?
I will use an SSD for testing the projects.

- What encoding will the files be in?
UTF-8. I will not use any weird characters that require thinking of more than a Java `char`. I do not recommend using byte representations of strings.

- How do I de-activate CPU cores in Linux?
See [http://www.cyberciti.biz/faq/debian-rhel-centos-redhat-suse-hotplug-cpu/](http://www.cyberciti.biz/faq/debian-rhel-centos-redhat-suse-hotplug-cpu/).

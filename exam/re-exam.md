# Instructions for the Re-Exam

To pass the course, you have to prepare a software project and a written report
on it. Everything has to be uploaded as a single zip file containing the following:
- `report.pdf`: this is the written report.
- `code`: a directory containing all source code of the software project.

Detailed instructions on the two items are given below.

## Hand-in

An assignment will be opened on Blackboard for handing in the project. The deadline for uploading the project on Blackboard will be: 19 June 2016 at midnight.

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

The `code` subdirectory in the zip file must contain a `numfinder` subdirectory that implements the `NumFinder` class found in this directory (see `NumFinder` in the subdirectory `numfinder/src/cp`).
To be sure that you are getting the class names and method signatures right, copy the `numfinder` subdirectory from this repository and start from there. Concretely, you must implement the methods `findAll`, `findAny` and `stats` in class `NumFinder`.
The class contains documentation about what these methods are supposed to do.

I suggest that you use the [NetBeans IDE](https://netbeans.org/) to develop the project. The easiest way is to follow the steps below:
- Open the project `numfinder` that you have just copied in your filesystem.
- Edit method `main` in class `Main` to test the methods you have implemented in `NumFinder`. Your code in `Main.main` will be completely disregarded in the evaluation. Only the implementation of `NumFinder` will be evaluated.

Using NetBeans is an easy way to ensure that I will be able to compile your code correctly. If the code does not compile the exam is automatically failed, so make sure that it does!


# Frequently Asked Questions and Comments

- What version of NetBeans should we use? Use at least version 8.

- The project will be tested using Java 8.

- Only text files should be looked into.
A text file is a file ending with the `.txt` suffix.

- Including external libraries is forbidden.
You can only use the Java standard library.

- Be careful: when I measure the time it takes your method calls to terminate, having threads that have not terminated may slow down the measurement.

- How do I traverse directories?
There are different ways to traverse directories in Java. See: [http://www.adam-bien.com/roller/abien/entry/listing_directory_contents_with_jdk](http://www.adam-bien.com/roller/abien/entry/listing_directory_contents_with_jdk) and [https://docs.oracle.com/javase/tutorial/essential/io/walk.html](https://docs.oracle.com/javase/tutorial/essential/io/walk.html). There is no "best" way for the project, since maybe one way will play nicer than the others with how you intend to program concurrency. You can also see the (simple!) example in `lectures`.

- What about the storage?
I will use an SSD for testing the projects.

- What encoding will the files be in?
UTF-8. I will not use any weird characters that require thinking of more than a Java `char`. I do not recommend using byte representations of strings.

- How do I de-activate CPU cores in Linux?
See [http://www.cyberciti.biz/faq/debian-rhel-centos-redhat-suse-hotplug-cpu/](http://www.cyberciti.biz/faq/debian-rhel-centos-redhat-suse-hotplug-cpu/).

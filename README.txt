1. In src/main/java/urinals.java change the file reader location (line #85) to point to the input file (urinal.dat) which is located in /src/Helper.
2. In src/main/java/urinals.java change the output file location path (line #60) to point to the location where the output is to be saved (src/Output).
3. In src/test/java/main/java/urinalsTest.java change the output file location path (line #105) to point to the location where the output is to be saved (src/Output),
    change only "/Users/adamshoaibk/IdeaProjects/ICA8/src/Output/rule".
3. Run urinals.java to see the working of the project, follow the instructions in the command prompt. Either chose keyboard input or input from file.
4. Run urinalsTest.java to see the jUnit test cases running.
5. For the input from a file, the program will run until it finds "-1" as an input from the file or until it reaches <eof>.
6. For every invalid input from the file the writer prints -1 to the file and continues to the next line.
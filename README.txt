project folder:
Veronika131-cs1c-project03/



Brief description of submitted files:


docs/
    - JavaDocs folder based on source code



src/stacks/BrowserNavigation.java
    - Simulates a browser's back and forward buttons by recording links that are visited.

src/stacks/Navigator.java
    - Provides the navigation features of class BrowserNavigation.

src/stacks/StackList.java
    - Manages items in a singly linked list where we can only push() and pop() items
      from one end of the stack.



resources/links.txt
    - Input file used by BroswerNavigation.java to test browser links and functions.

resources/links2.txt
    - Input file used by BroswerNavigation.java to test browser links boundary when forward
     link stack is empty.

resources/links3.txt
    - Input file used by BroswerNavigation.java to test browser links boundary when both
      stacks are empty.

resources/links4.json
    - Input file used by BroswerNavigation.java to test browser functions going back
      and forward between links repeatedly.

resources/popEmptyStackOfLinks.json
    - Input file used by BroswerNavigation.java to test browser navigation boundary
      case when back link stack is empty.

resources/RUN.txt
    - Various test outputs of BrowserNavigation class that display different browser history
      depending on visited links and use of goBack and goForward functions.



.gitignore
    - .gitignore content tells git to ignore specified things.

README.txt
    - Description of submitted files.
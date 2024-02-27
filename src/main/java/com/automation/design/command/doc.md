# Goal

- Encapsulate a request/command to be executed as an object, pass it to an Invoker. The invoker executes the command.
- To achieve complete decoupling between Sender & Receiver.
- Their behavior is wrapped inside an object. And you pass it to the invoker here The invoker is a test class
- So this is extremely useful to achieve a decoupling between the sender and receiver that is here. Sender and receiver are basically the page object and test classes
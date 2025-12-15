# sequential()

sequential() converts a parallel stream back into a sequential stream, so elements are processed one by one using a single thread, in order.

## Example:

list.parallelStream().sequential().forEach(System.out::println);

Interview line: sequential() forces the stream to run in single-threaded mode even if it was parallel.

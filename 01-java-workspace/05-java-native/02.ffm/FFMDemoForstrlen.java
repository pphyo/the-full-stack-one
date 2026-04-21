import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class FFMDemoForstrlen {

    void main() throws Throwable {

        IO.println("=== Testing Java FFM APIs ===");

        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();

        MemorySegment segment = stdlib.find("strlen")
                .orElseThrow(() -> new RuntimeException("strlen function not found!"));

        FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);

        MethodHandle strlen = linker.downcallHandle(segment, descriptor);

        try (Arena arena = Arena.ofConfined()) {
            var cString = arena.allocateFrom("Hello from Java FFM API!");
            long length = (long) strlen.invokeExact(cString);

            IO.println("Total length of word:" + length);
        }

    }

}
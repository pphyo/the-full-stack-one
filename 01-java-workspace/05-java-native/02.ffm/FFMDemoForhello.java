import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class FFMDemoForhello {

    void main() {
        Util ut = new Util();
        ut.sayHello();

        int result = ut.add(11, 4);
        IO.println("Add result: " + result);
    }

}

class Util {

    static Linker linker = Linker.nativeLinker();

    int add(int a, int b) {
        try (Arena arena = Arena.ofConfined()) {
            SymbolLookup customLib = SymbolLookup.libraryLookup("libhello.dylib", arena);

            // find add method
            MethodHandle addHandle = linker.downcallHandle(
                    customLib.find("add").orElseThrow(),
                    FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));

            IO.println("Calling add from C");
            return (int) addHandle.invokeExact(a, b);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Cannot add!");
    }

    void sayHello() {

        try (Arena arena = Arena.ofConfined()) {
            SymbolLookup customLib = SymbolLookup.libraryLookup("libhello.dylib", arena);

            // find say_hello method
            MethodHandle sayHelloHandle = linker.downcallHandle(
                    customLib.find("say_hello").orElseThrow(),
                    FunctionDescriptor.ofVoid());

            IO.println("Calling say_hello() from C");
            sayHelloHandle.invokeExact();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
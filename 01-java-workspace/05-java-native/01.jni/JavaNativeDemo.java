public class JavaNativeDemo extends Object {

    private native void printFromNative();

    static {
        System.loadLibrary("jnative");
    }

    void main() {
        printFromNative();
    }

}

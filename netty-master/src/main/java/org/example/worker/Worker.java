// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: worker.proto

package org.example.worker;

public final class Worker {
  private Worker() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_TaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_TaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_TaskResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_TaskResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\014worker.proto\022\005proto\".\n\013TaskRequest\022\016\n\006" +
      "offset\030\001 \001(\003\022\017\n\007message\030\002 \001(\t\".\n\014TaskRes" +
      "ponse\022\016\n\006offset\030\001 \001(\003\022\016\n\006status\030\002 \001(\t2C\n" +
      "\rWorkerService\0222\n\007execute\022\022.proto.TaskRe" +
      "quest\032\023.proto.TaskResponseB\026\n\022org.exampl" +
      "e.workerP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_proto_TaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_TaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_TaskRequest_descriptor,
        new String[] { "Offset", "Message", });
    internal_static_proto_TaskResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_TaskResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_TaskResponse_descriptor,
        new String[] { "Offset", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

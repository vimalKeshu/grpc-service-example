// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: worker.proto

package org.example.worker;

public interface TaskRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.TaskRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 offset = 1;</code>
   * @return The offset.
   */
  long getOffset();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}

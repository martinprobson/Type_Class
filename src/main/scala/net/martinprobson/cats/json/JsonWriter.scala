package net.martinprobson.cats.json

// This is our type class.
// The "serialize to JSON" behaviour is encoded in this trait
trait JsonWriter[A] {
  def write(value: A): Json
}

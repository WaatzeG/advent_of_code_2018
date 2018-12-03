(ns aoc.1
 (:require [clojure.java.io :as io] ) )

(with-open [rdr (clojure.java.io/reader (io/resource "1_frequency_shifts.txt"))]
  (println "Frequency:" (reduce + (map #(Integer/parseInt %) (line-seq rdr)))))
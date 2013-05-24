(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.core :refer :all]))

(deftest a-test
    (is (= 233168 (no1 1e3)))
    (is (= 4613732 (no2 4e6)))
)

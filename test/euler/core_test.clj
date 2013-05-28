(ns euler.core-test
  (:require [clojure.test :refer :all]
           	[euler.problem1] 
			[euler.problem2]
			[euler.problem3]
			[euler.problem4]
			[euler.problem5]
			))

(deftest a-test
    (is (= 233168 		(euler.problem1/calc 1e3)))
    (is (= 4613732		(euler.problem2/calc 4e6)))
    (is (= 6857 		(euler.problem3/calc 600851475143)))
    (is (= 906609		(euler.problem4/calc 3)))
    (is (= 232792560	(euler.problem5/calc 20)))
)

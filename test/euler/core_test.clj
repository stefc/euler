(ns euler.core-test (:require
      [clojure.test :refer :all]
      [euler.problem1] 
			[euler.problem2]
			[euler.problem3]
			[euler.problem4]
      [euler.problem5]
      [euler.problem6]
      [euler.problem7]        
      [euler.problem8]        
      [euler.problem9]        
      [euler.problem10]
      [euler.problem11]
      [euler.problem13]
			[euler.problem37]
))

(deftest a-test 
    (is (= 233168     		(euler.problem1/calc 1e3)))
    (is (= 4613732        (euler.problem2/calc 4e6)))
    (is (= 6857 	       	(euler.problem3/calc 600851475143)))
    (is (= 906609      		(euler.problem4/calc 3)))
    (is (= 232792560      (euler.problem5/calc 20)))
    (is (= 25164150       (euler.problem6/calc 100)))
    (is (= 104743         (euler.problem7/calc 10001)))
    (is (= 40824          (euler.problem8/calc 5)))
    (is (= 31875000       (euler.problem9/calc 1000)))
    (is (= 142913828922   (euler.problem10/calc 2e6)))
    (is (= 70600674       (euler.problem11/calc 4)))
    (is (= 5537376230     (euler.problem13/calc 10)))
    (is (= 748317         (euler.problem37/calc 11)))
)

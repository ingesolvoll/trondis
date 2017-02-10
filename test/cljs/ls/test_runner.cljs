(ns ls.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [ls.core-test]
   [ls.common-test]))

(enable-console-print!)

(doo-tests 'ls.core-test
           'ls.common-test)

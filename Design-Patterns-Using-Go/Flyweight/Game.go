from abc import ABC, abstractmethod

class Flyweight(ABC):
    def __init__(self, intrinsic_state):
        self.intrinsic_state = intrinsic_state  # intrinsic state  # repeted state

    @abstractmethod
    def operation(self, extrinsic_state): # extrinsic state
        pass

class ConcreteFlyweight(Flyweight):
    def operation(self, extrinsic_state):
        print("Operation inside concrete flyweight.")


class FlyweightFactory:
    def __init__(self):
        self._flyweights = {}

    def getFlyweight(self, intrinsic_state):
        if intrinsic_state not in self._flyweights:
            self._flyweights[intrinsic_state] = ConcreteFlyweight(intrinsic_state)
        return self._flyweights[intrinsic_state]

class ClientClass:
    def __init__(self, factory, intrinsic_state, extrinsic_state):
        self.flyweitht = factory.getFlyweight(intrinsic_state) 
        self.extrinsic_state = extrinsic_state

    def operation(self):
        print("Operation inside context.")
        self.flyweitht.operation(self.extrinsic_state)

# Client code
factory = FlyweightFactory()
c = ClientClass(factory, "common", "separate1")
c.operation()

c2 = ClientClass(factory, "common", "separate2")
c2.operation()

print(c, c2)
print(c.flyweitht, c2.flyweitht)
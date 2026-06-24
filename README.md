Parking Lot — Low Level Design (Java)

A multi-level parking lot management system designed using object-oriented
design principles and classic design patterns. Built as part of LLD interview
preparation (SDE-2/SDE-3 level).

Problem Statement

Design a parking lot system that:


Supports multiple vehicle types (Car, Bike, Truck)
Supports multiple parking spot types (Compact, Large, Motorcycle, Handicapped)
Spans multiple levels/floors
Allocates the correct spot type to each vehicle on entry
Issues a ticket on entry and calculates a fee on exit based on duration and vehicle type
Is easily extensible to new vehicle types, spot types, and pricing rules


Design Patterns Used

PatternWhereWhySingletonParkingLotOnly one parking lot instance should exist and coordinate all levels/spotsStrategyPricingStrategy (per vehicle type)Pricing rules vary by vehicle and can change independently without touching other classesStrategySpotAllocationStrategySpot-type lookup is decoupled from the allocation/parking logic

Core Entities


ParkingLot — Singleton entry point; owns levels, active tickets, and pricing strategies
Level — A floor containing a list of ParkingSpots
ParkingSpot — A single spot with a type (SpotType) and status (FREE/OCCUPIED)
Vehicle (abstract) — Car, Bike, Truck
Ticket — Created on entry, tracks entry/exit time and the assigned spot
PricingStrategy — One implementation per vehicle type, calculates fee from parked duration



┌─────────────────────────┐
│      ParkingLot         │ (Singleton)
├─────────────────────────┤
│ - levels: List<Level>   │
│ - activeTickets: Map    │
├─────────────────────────┤
│ + parkVehicle()         │
│ + unparkVehicle()       │
└─────────────────────────┘
          │ has many
          ▼
┌─────────────────────────┐
│        Level            │
├─────────────────────────┤
│ - spots: List<Spot>     │
├─────────────────────────┤
│ + findFreeSpot()        │
└─────────────────────────┘
          │ has many
          ▼
┌─────────────────────────┐
│      ParkingSpot        │
├─────────────────────────┤
│ - spotType: SpotType    │
│ - status: SpotStatus    │
│ - parkedVehicle: Vehicle│
└─────────────────────────┘
          ▲ parked in
          │
┌─────────────────────────┐
│   <<abstract>> Vehicle  │
├─────────────────────────┤
│ - licensePlate          │
│ - type: VehicleType     │
└─────────────────────────┘
          ▲
    ┌─────┼──────┐
    │     │      │
┌──────┐┌──────┐┌──────┐
│ Car  ││ Bike ││Truck │
└──────┘└──────┘└──────┘

┌──────────────────────────┐
│ <<interface>>            │
│ SpotAllocationStrategy   │
│ + getRequiredSpotType()  │
└──────────────────────────┘

┌──────────────────────────┐
│ <<interface>>            │
│  PricingStrategy         │
│ + calculateFee()         │
└──────────────────────────┘

┌─────────────────────────┐
│        Ticket           │
├─────────────────────────┤
│ - entryTime, exitTime   │
│ - vehicle, spot         │
└─────────────────────────┘




Known Design Trade-off (intentional, documented for discussion)

The initial DefaultAllocationStrategy used a switch on VehicleType to
resolve the required SpotType, which violates the Open/Closed Principle —
adding a new vehicle type (e.g. ElectricCar) requires modifying that switch.

A cleaner alternative: let each Vehicle subclass expose its own
getRequiredSpotType(), so adding a new vehicle type requires zero
modification to existing classes — only a new subclass. This trade-off is
called out deliberately to demonstrate the kind of OCP analysis expected at
SDE-3 level interviews.

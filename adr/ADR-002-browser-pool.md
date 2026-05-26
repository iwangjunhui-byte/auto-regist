# ADR-002 Browser Pool

## Status

Accepted

## Context

Creating browser instances for every workflow causes heavy memory usage and slow startup.

## Decision

Adopt reusable browser pool architecture.

## Consequences

Advantages:

- reusable browsers
- better concurrency
- lower startup cost

Disadvantages:

- lifecycle complexity
- recycle management required
